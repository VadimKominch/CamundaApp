package org.example.application;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.runtime.ProcessInstanceQuery;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class CamundaRuntimeService {
    private final RuntimeService runtimeService;
    private static final String MAIN_PROCESS_DEFINITION_KEY = "process";
    public static final String FLAG_CHECKED = "flagChecked";
    public CamundaRuntimeService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public void startProcess(String businessKey) {
        runtimeService.startProcessInstanceByKey(MAIN_PROCESS_DEFINITION_KEY, businessKey, new HashMap<>() {{
            put("value", Math.random() * 50);
        }});
    }

    public void correlateOnCheckedFlag(String businessKey) {
        ProcessInstance processInstance = queryMainProcessInstance(businessKey).singleResult();
        runtimeService.setVariable(processInstance.getId(),FLAG_CHECKED, true);
    }

    private Boolean hasActiveProcess(String businessKey) {
      return queryMainProcessInstance(businessKey).active().count() > 0;
    }

    private ProcessInstanceQuery queryMainProcessInstance(String businessKey) {
        return queryProcessInstance(businessKey, MAIN_PROCESS_DEFINITION_KEY);
    }

    private ProcessInstanceQuery queryProcessInstance(String businessKey, String definitionKey) {
        return runtimeService.createProcessInstanceQuery()
                .processInstanceBusinessKey(businessKey)
                .processDefinitionKey(definitionKey);
    }
}
