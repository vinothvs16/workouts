package workout.springwebapp.writers;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;

import workout.springwebapp.model.User;

public class DBItemWriters implements ItemWriter<User> {

	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void write(List<? extends User> users) throws Exception {

		JdbcTemplate template = new JdbcTemplate(dataSource);
		for (User user : users) {
			template.update(
					"insert into user (name,age) values('"+ user.getName() + "'," + user.getAge() + ")");
		}

	}

}
