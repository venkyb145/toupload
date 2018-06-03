package io.javapractice.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class TopicService {
	@Autowired
	private TopicRepository TopicRepository;
	private List<Topic> topics= new ArrayList<>(Arrays.asList(
				
			new Topic("spring","springframework","springdescription"),	
			new Topic("java","javaframework","javadescription"),
			new Topic("javascript","javascriptframework","javascriptdescription")
				));
	public List<Topic> getAllTopics(){
		//return topics;
		List<Topic> Topics=new ArrayList<>(); 
		TopicRepository.findAll()
		.forEach(Topics::add);
		return Topics;
	}
		public Topic getTopic(String id) {
			//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
			return TopicRepository.findById(id);
		}
		public void addTopic(Topic topic) {
			// TODO Auto-generated method stub
			//topics.add(topic);
			TopicRepository.save(topic);
			
		}
		public void updateTopic(String id, Topic topic) {
			// TODO Auto-generated method stub
			//for(int i=0; i<topics.size(); i++) {
				//Topic t=topics.get(i);
				//if(t.getId().equals(id)) {
					//topics.set(i, topic);
					//return;
				//}
			//}
			TopicRepository.save(topic);
		}
		public void deleteTopic(String id) {
			//topics.removeIf(t ->t.getId().equals(id));
			TopicRepository.deleteById(id);
		} 
}
