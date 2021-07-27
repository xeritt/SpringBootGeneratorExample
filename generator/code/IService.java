package {PACKAGE}.service;

import {PACKAGE}.model.{MODEL};
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface I{MODEL}Service {
    List<{MODEL}> getAll{MODELS}();

    {MODEL} get{MODEL}ById(int id);

    @Transactional
    void saveOrUpdate({MODEL} {VARIBLE});

    @Transactional
    void delete(int id);

    @Transactional
    {MODEL} create{MODEL}({MODEL} {VARIBLE});
}
