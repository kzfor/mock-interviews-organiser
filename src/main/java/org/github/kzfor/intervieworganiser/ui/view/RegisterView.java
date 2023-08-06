package org.github.kzfor.intervieworganiser.ui.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.github.kzfor.intervieworganiser.common.security.SecurityPort;

@Route(value = "register")
@AnonymousAllowed
public class RegisterView extends Composite<Component> {

    private final SecurityPort securityPort;

    public RegisterView(SecurityPort securityPort) {
        this.securityPort = securityPort;
    }

    @Override
    protected Component initContent() {
        var username = new TextField("Username");
        var password = new PasswordField("Password");
        var passwordConfirm = new PasswordField("Confirm password");
        return new VerticalLayout(
                new H2("Register"),
                username,
                password,
                passwordConfirm,
                new Button("Register", event -> register(
                        username.getValue(),
                        password.getValue(),
                        passwordConfirm.getValue()
                ))
        );
    }

    private void register(String username, String password, String passwordConfirm) {
        securityPort.createUser(username, password);
    }
}
