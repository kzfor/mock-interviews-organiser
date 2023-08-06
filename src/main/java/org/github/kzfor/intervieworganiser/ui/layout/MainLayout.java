package org.github.kzfor.intervieworganiser.ui.layout;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.spring.security.AuthenticationContext;
import org.github.kzfor.intervieworganiser.common.security.domain.UserDetailsImpl;
import org.github.kzfor.intervieworganiser.common.security.entities.User;
import org.github.kzfor.intervieworganiser.ui.view.LoginView;
import org.github.kzfor.intervieworganiser.ui.view.RegisterView;

import java.util.ArrayList;

public class MainLayout extends AppLayout {

    private final transient AuthenticationContext authContext;

    public MainLayout(AuthenticationContext authContext) {
        this.authContext = authContext;
        var isUserAuthenticated = authContext.isAuthenticated();
        // Init title
        H1 title = new H1("MyApp");
        addToNavbar(title);

        // Init navbar
        initSpecialTabs(isUserAuthenticated);
    }

    private Tabs getNavigationTabs() {
        Tab details = new Tab("Details");
        Tab payment = new Tab("Payment");
        Tab shipping = new Tab("Shipping");

        Tabs tabs = new Tabs(details, payment, shipping);
        return tabs;
    }

    private void initSpecialTabs(boolean isUserAuthenticated) {
        var links = new ArrayList<RouterLink>();
        var component = new HorizontalLayout();
        if (!isUserAuthenticated) {
            links.add(new RouterLink("Sign in", RegisterView.class));
            links.add(new RouterLink("Sing up", LoginView.class));
        } else {
            var helloMessage = new H3(String.format("Hello, %s!", authContext.getPrincipalName().get()));
            var logout = new Button("Logout", onPress -> authContext.logout());
            component.add(helloMessage, logout);
        }
        links.forEach(component::add);
        component.setAlignSelf(FlexComponent.Alignment.END);
        addToNavbar(component);
    }
}
