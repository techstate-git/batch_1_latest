package dto.serialize;

import dto.deserialize.Activities;

public class PostCalls {
    private static Activities createActivity(int id, String title, String dueDate, boolean isCompleted){
        Activities activities = new Activities();

        activities.setId(id);
        activities.setTitle(title);
        activities.setDueDate(dueDate);
        activities.setCompleted(isCompleted);

        return activities;
    }
}
