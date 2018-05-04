package workout.springwebapp.processors;

import org.springframework.batch.item.ItemProcessor;

import workout.springwebapp.model.User;

public class StringArrayUserProcessor implements ItemProcessor<String[],User>{

	public User process(String[] arg0) throws Exception {
		User user = new User();
		//user.setId(Integer.valueOf(arg0[0]));
		user.setName(arg0[0]);
		user.setAge(Double.valueOf((arg0[1])).intValue());
		return user;
	}

	
}
