package com.vsb.vea.project.dao.fakedb.impl;

import com.vsb.vea.project.dto.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


public class EntityDB<T extends Entity> {

	private List<T> entities = new ArrayList<>();
	private long lastId = 0;

	public EntityDB() {
	}
	
	public List<T> getAll() {
		return entities;
	}

	public List<T> getFiltered(Function<T, Boolean> filter) {
		return entities.stream().filter(filter::apply).collect(Collectors.toList());
	}

	public void insert(T e) {
		e.setId(++lastId);
		entities.add(e);
	}

	public void merge(T e) {
		T old = find(e.getId());
		if(old != null){
			old.merge(e);
		}
	}

	public T find(long id) {
		return entities.stream().filter(p -> p.getId() == id).findAny().orElse(null);
	}

	public void remove(long id) {
		entities.remove(find(id));
	}
}
