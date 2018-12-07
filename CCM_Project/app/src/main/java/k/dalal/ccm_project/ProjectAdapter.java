package k.dalal.ccm_project;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/*

RecyclerView.Adapter
RecyclerView.ViewHolder

 */
public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder> {

    private Context mCtx;
    private List<Project> projectList;

    public ProjectAdapter(Context mCtx, List<Project> projectList) {
        this.mCtx = mCtx;
        this.projectList = projectList;
    }


    // INFLATE
    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       /* LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.view_item, null); // CKk
        ProjectViewHolder holder = new ProjectViewHolder(view);
        return holder;
        */
        View view = LayoutInflater.from(mCtx).inflate(R.layout.view_item, viewGroup, false);
        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder projectViewHolder, int i) {
        Project project = projectList.get(i);

        projectViewHolder.textViewName.setText(project.getProjectName());
        projectViewHolder.textViewDescription.setText(project.getProjectDescription());
        projectViewHolder.textViewSize.setText(project.getProjectSize());

    }

    @Override
    public int getItemCount() {
        return projectList.size();
    }

    class ProjectViewHolder extends RecyclerView.ViewHolder
    {
        TextView textViewName, textViewDescription, textViewSize;

        public ProjectViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textViewName);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            textViewSize = itemView.findViewById(R.id.textViewSize);

        }
    }
}
