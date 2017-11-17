package ru.kpfu.tools.cct.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import ru.kpfu.tools.cct.rest.controllers.dto.TaskDto;

import org.codehaus.jackson.map.ObjectMapper;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

public class TasksSimpleController {

    private Main mainApp;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private Label taskIdLabel;

    @FXML
    private Label taskAuthorIdLabel;

    @FXML
    private Label taskInstructionsFileUrlLabel;

    @FXML
    private void handleGetTask() {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8080/tsct/tasks/0.json");
        Response response = target.request(MediaType.APPLICATION_JSON_TYPE).get();
        ObjectMapper objectMapper = new ObjectMapper();
        String value = response.readEntity(String.class);
        try {
            TaskDto dto = objectMapper.readValue(value, TaskDto.class);
            taskIdLabel.setText(dto.getId());
            taskAuthorIdLabel.setText(dto.getAuthorId());
            taskInstructionsFileUrlLabel.setText(dto.getLinks().getInstructionsFile());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
