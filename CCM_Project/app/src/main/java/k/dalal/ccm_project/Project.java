package k.dalal.ccm_project;

import java.util.List;

public class Project {

    public String projectName;
    public String projectDescription;
    public String projectSize;
    public String projectStudents;

    public Project() {
    }

    public Project(String projectName, String projectDescription, String projectSize) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.projectSize = projectSize;

    }

    public Project(String projectStudents)
    {
        this.projectStudents = projectStudents;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectSize() {
        return projectSize;
    }

    public void setProjectSize(String projectSize) {
        this.projectSize = projectSize;
    }

    public String getProjectStudents() {
        return projectStudents;
    }

    public void setProjectStudents(String projectStudents) {
        this.projectStudents = projectStudents;
    }

    public List<Project> Project;
}
