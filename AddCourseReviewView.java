package com.example.application.views.addcoursereview;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

@PageTitle("Add Course Review")
@Route(value = "person-form", layout = MainLayout.class)
@Uses(Icon.class)
public class AddCourseReviewView extends Composite<VerticalLayout> {

    public AddCourseReviewView() {
        VerticalLayout layoutColumn2 = new VerticalLayout();
        H3 h3 = new H3();
        FormLayout formLayout2Col = new FormLayout();
        TextField firstName = new TextField();
        TextField lastName = new TextField();
        TextField subject = new TextField();
        TextField courseLevel = new TextField();
        TextField university = new TextField();
        TextField rating = new TextField();
        Checkbox wouldTakeAgain = new Checkbox();
        HorizontalLayout layoutRow = new HorizontalLayout();
        Button buttonPrimary = new Button();
        Button buttonSecondary = new Button();
        TextArea description = new TextArea();

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().setJustifyContentMode(JustifyContentMode.START);
        getContent().setAlignItems(Alignment.CENTER);
        layoutColumn2.setWidth("100%");
        layoutColumn2.setMaxWidth("800px");
        layoutColumn2.setHeight("min-content");
        h3.setText("Course Review");
        h3.setWidth("100%");
        formLayout2Col.setWidth("100%");
        firstName.setLabel("First Name");
        lastName.setLabel("Last Name");
        subject.setLabel("Subject");
        courseLevel.setLabel("Course Level");
        university.setLabel("University");
        rating.setLabel("Rating");
        wouldTakeAgain.setLabel("Would Take Again");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        buttonPrimary.setText("Save");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonSecondary.setText("Cancel");
        buttonSecondary.setWidth("min-content");
        description.setLabel("Add any relevant course information.");
        description.setWidth("100%");
        getContent().add(layoutColumn2);
        layoutColumn2.add(h3);
        layoutColumn2.add(formLayout2Col);
        formLayout2Col.add(firstName);
        formLayout2Col.add(lastName);
        formLayout2Col.add(subject);
        formLayout2Col.add(courseLevel);
        formLayout2Col.add(university);
        formLayout2Col.add(rating);
        formLayout2Col.add(wouldTakeAgain);
        layoutColumn2.add(layoutRow);
        layoutRow.add(buttonPrimary);
        layoutRow.add(buttonSecondary);
        getContent().add(description);
    
    buttonPrimary.addClickListener(event -> {
        MyEntity myEntity = new MyEntity();
        myEntity.setFirstName(firstName.getValue());
        myEntity.setLastName(lastName.getValue());
        myEntity.setSubject(subject.getValue());
        myEntity.setCourseLevel(courseLevel.getValue());
        myEntity.setUniversity(university.getValue());
        myEntity.setRating(rating.getValue());
        myEntity.setWouldTakeAgain(wouldTakeAgain.getValue());
        myEntity.setDescription(description.getValue());
        myEntity.saveToDatabase();
        Notification.show("Data saved successfully");
     });
     
}
}
