package {PACKAGE}.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@ToString
@Entity
public class {MODEL} {

	    @Id
	    @GeneratedValue
	    private int id;
		{VARS}
}
