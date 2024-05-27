package com.educacionit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educacionit.entity.Publisher;
import com.educacionit.repository.PublisherRepository;

@Service
public class PublisherService {

	@Autowired
	private PublisherRepository publisherRepository;
	
	public Publisher savePublisher(Publisher publisher) {
		return publisherRepository.save(publisher);
	}
	
	public void deletePublisher(Long publisherId) {
		publisherRepository.deleteById(publisherId);
	}
	
	public List<Publisher> findAllPublishers() {
		return publisherRepository.findAll();
	}
}
