package k.dalal.ccm_project;

public class Project {

    private String projectName;
    private String projectDescription;
    private String projectSize;
    private String[] projectStudents;

    public Project() {

    }

    public Project(String projectName, String projectDescription, String projectSize, String[] projectStudents) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.projectSize = projectSize;
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

    public String[] getProjectStudents() {
        return projectStudents;
    }

    public void setProjectStudents(String[] projectStudents) {
        this.projectStudents = projectStudents;
    }
}
