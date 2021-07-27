package {PACKAGE}.service;
import java.util.ArrayList;
import java.util.List;

import {PACKAGE}.model.{MODEL};
import {PACKAGE}.repository.{MODEL}Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class {MODEL}Service implements I{MODEL}Service {

    @Autowired
    {MODEL}Repository {VARIBLE}Repository;

    @Override
    public List<{MODEL}> getAll{MODELS}() {
        List<{MODEL}> {VARIBLES} = new ArrayList<{MODEL}>();
        {VARIBLE}Repository.findAll().forEach({VARIBLE} -> {VARIBLES}.add({VARIBLE}));
        return {VARIBLES};
    }

    @Override
    public {MODEL} get{MODEL}ById(int id) {
        return {VARIBLE}Repository.findById(id).get();
    }

    @Override
    public void saveOrUpdate({MODEL} {VARIBLE}) {
        {VARIBLE}Repository.save({VARIBLE});
    }

    @Override
    public void delete(int id) {
        {VARIBLE}Repository.deleteById(id);
    }

    @Override
    @Transactional
    public {MODEL} create{MODEL}({MODEL} {VARIBLE}) {
        return {VARIBLE}Repository.save({VARIBLE});
    }

}