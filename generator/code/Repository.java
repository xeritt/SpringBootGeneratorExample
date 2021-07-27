	package {PACKAGE}.repository;
	
	import {PACKAGE}.model.{MODEL};
	import org.springframework.data.repository.CrudRepository;
	
	public interface {MODEL}Repository extends CrudRepository<{MODEL}, Integer> {}