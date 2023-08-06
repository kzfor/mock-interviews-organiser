package org.github.kzfor.intervieworganiser.ui.view;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.github.kzfor.intervieworganiser.ui.layout.MainLayout;

@PageTitle("Hello world")
@Route(value = "", layout = MainLayout.class)
@AnonymousAllowed
public class MainView extends VerticalLayout {
    public MainView() {
        add(new H1("Hello world!"));
    }
}
