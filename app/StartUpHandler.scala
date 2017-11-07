package modules

import javax.inject._

import org.camunda.bpm.engine.{ProcessEngineConfiguration, ProcessEngines}
import play.api.{Logger}


@Singleton
class StartUpHandler() {
  val conf = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration()
    .setJdbcDriver("org.postgresql.Driver")
    .setJdbcUrl("jdbc:postgresql://localhost/process-engine")
    .setJdbcUsername("camunda")
    .setJdbcPassword("camunda")
    .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE)
    .setHistory(ProcessEngineConfiguration.HISTORY_FULL)
    .setJobExecutorActivate(true)


  Logger.info("Starting process engine...")
  val engine = conf.buildProcessEngine()

  Logger.info("Deploying process definition...")
  val deployment = engine.getRepositoryService.createDeployment()
  deployment.addClasspathResource("loan-approval.bpmn").enableDuplicateFiltering(true)
  deployment.deploy()
}