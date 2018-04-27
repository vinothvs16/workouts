package workout.springbatch.processors;

import org.springframework.batch.item.ItemProcessor;

import workout.springbatch.model.User;

public class StringArrayUserProcessor implements ItemProcessor<String[],User>{

	public User process(String[] arg0) throws Exception {
		User user = new User();
		user.setId(Integer.valueOf(arg0[0]));
		user.setName(arg0[1]);
		user.setAge(Integer.valueOf(arg0[2]));
		return user;
	}

	
}
