package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Child;
import com.example.demo.repository.ChildRepo;

@Service
public class ChildService {
	@Autowired
	ChildRepo cr;

	public List<Child> addChild(List<Child> c)
	{
		return (List<Child>)cr.saveAll(c);
	}

	public List<Child> getChildren(String field)
	{
		return cr.findAll(Sort.by(Sort.DEFAULT_DIRECTION,field));
	}

	public List<Child> getSpecific(int pgNo, int pgSize)
	{
		Page<Child> ch = cr.findAll(PageRequest.of(pgNo, pgSize));
		return ch.getContent();
	}

	public List<Child> getSortedPage(int pgNo, int pgSize, String field)
	{
		Page<Child> ch = cr.findAll(PageRequest.of(pgNo, pgSize, Sort.by(Sort.DEFAULT_DIRECTION, field)));
		return ch.getContent();
	}
}