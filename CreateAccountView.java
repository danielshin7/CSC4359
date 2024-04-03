package com.example.application.views.createaccount;

import com.example.application.views.MainLayout;
import com.example.application.views.addcoursereview.MyEntity;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Create Account")
@Route(value = "my-view2", layout = MainLayout.class)
@Uses(Icon.class)
public class CreateAccountView extends Composite<VerticalLayout> {

    public CreateAccountView() {
        EmailField email = new EmailField();
        TextField userName = new TextField();
        TextField password = new TextField();
        TextField educationLevel = new TextField();
        Button buttonPrimary = new Button();
        
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        email.setLabel("Email");
        email.setWidth("min-content");
        userName.setLabel("User Name");
        userName.setWidth("min-content");
        password.setLabel("Password");
        password.setWidth("min-content");
        educationLevel.setLabel("Education Level");
        educationLevel.setWidth("min-content");
        buttonPrimary.setText("Create");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        getContent().add(email);
        getContent().add(userName);
        getContent().add(password);
        getContent().add(educationLevel);
        getContent().add(buttonPrimary);
    

    buttonPrimary.addClickListener(event -> {
        MyUser myUser = new MyUser();
        myUser.setUserName(userName.getValue());
        myUser.setPassword(password.getValue());
        myUser.setEmail(email.getValue());
        myUser.setEducationLevel(educationLevel.getValue());
        myUser.saveToDatabase();
        Notification.show("Data saved successfully");
     });

    }
}
