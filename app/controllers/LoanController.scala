package controllers

import javax.inject.Inject
import play.api.mvc._

class LoanController  @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  def startLoanApprovalProcess(loanAmount: Int) = Action {
    import org.camunda.bpm.engine.ProcessEngines
    import org.camunda.bpm.engine.variable.Variables._

    val runtime = ProcessEngines.getDefaultProcessEngine.getRuntimeService
    val processVariables = createVariables().putValueTyped("loanAmount", integerValue(loanAmount))
    val processInstance = runtime.startProcessInstanceByKey("approve-loan", processVariables)

    Created("started process instance " + processInstance.getId)
  }
}
