package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Child;
import com.example.demo.service.ChildService;

@RestController
public class ChildController {

	@Autowired
	ChildService cs;

	@PostMapping("/postBaby")
	public boolean addBaby(@RequestBody List<Child> c)
	{
		try {
			cs.addChild(c);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@GetMapping("/getBabySorted")
	public List<Child> showBaby(@RequestParam(value = "field") String field)
	{
		return cs.getChildren(field);
	}

	@GetMapping("/getBabyPaged")
	public List<Child> showBabyPaged(@RequestParam(value = "pgNo")int pgNo, @RequestParam(value = "pgSize")int pgSize)
	{
		return cs.getSpecific(pgNo, pgSize);
	}

	@GetMapping("/getBabySortedAndPaged")
	public List<Child> showBabyPagedSorted(@RequestParam(value = "pgNo")int pgNo, @RequestParam(value = "pgSize")int pgSize, @RequestParam(value = "field") String field)
	{
		return cs.getSortedPage(pgNo, pgSize, field);
	}

}