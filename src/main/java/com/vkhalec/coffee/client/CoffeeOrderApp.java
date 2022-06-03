package com.vkhalec.coffee.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.vkhalec.coffee.shared.Coffee;
import com.vkhalec.coffee.shared.CoffeeMachine;
import com.vkhalec.coffee.shared.CoffeeOrder;

public class CoffeeOrderApp implements EntryPoint {

    final Button confirmButton = new Button("Подтвердить");
    final TextBox coffeeIdField = new TextBox();
    final TextBox coffeeMachineIdField = new TextBox();
    final Label errorLabel = new Label();

    VerticalPanel dialogVPanel = new VerticalPanel();
    final DialogBox dialogBox = new DialogBox();
    final HTML serverResponseHtml = new HTML();
    final Label sendToServerLabel = new Label();
    final Button closeButton = new Button("Закрыть");

    private final CoffeeOrderServiceAsync coffeeOrderService = CoffeeOrderServiceAsync.Util.getInstance();

    public void onModuleLoad() {

        final Label coffeeMachineIdLabel = new Label();
        coffeeMachineIdLabel.setText("Номер кофемашины: ");
        RootPanel.get("coffeeMachineLabelId").add(coffeeMachineIdLabel);
        RootPanel.get("coffeeMachineId").add(coffeeMachineIdField);

        final Label coffeeIdLabel = new Label();
        coffeeIdLabel.setText("Номер напитка: ");
        RootPanel.get("coffeeLabelId").add(coffeeIdLabel);
        RootPanel.get("coffeeId").add(coffeeIdField);

        RootPanel.get("confirmButtonId").add(confirmButton);
        RootPanel.get("errorLabelContainer").add(errorLabel);

        dialogBox.setText("Обращение к кофемашине");
        dialogBox.setAnimationEnabled(true);

        closeButton.getElement().setId("closeButtonId");

        dialogVPanel.addStyleName("dialogVPanel");
        dialogVPanel.add(new HTML("<b>Введена команда:</b>"));
        dialogVPanel.add(sendToServerLabel);
        dialogVPanel.add(new HTML("<br><b>Получен ответ:</b>"));
        dialogVPanel.add(serverResponseHtml);
        dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
        dialogVPanel.add(closeButton);
        dialogBox.setWidget(dialogVPanel);

        closeButton.addClickHandler(event -> {
            dialogBox.hide();
            confirmButton.setEnabled(true);
            confirmButton.setFocus(true);
        });

        class CoffeeOrderHandler implements ClickHandler, KeyUpHandler {

            public void onClick(ClickEvent event) {
                sendInfoToServer();
            }

            public void onKeyUp(KeyUpEvent event) {
                if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
                    sendInfoToServer();
                }
            }

            private void sendInfoToServer() {

                errorLabel.setText("");
                CoffeeOrder coffeeOrderDto = new CoffeeOrder();

                coffeeOrderDto.setCoffee(new Coffee(coffeeIdField.getText()));
                coffeeOrderDto.setCoffeeMachine(new CoffeeMachine(coffeeMachineIdField.getText()));

                confirmButton.setEnabled(false);
                sendToServerLabel.setText("coffee id=" + coffeeOrderDto.getCoffee().getId() +
                        "coffeemachine id=" + coffeeOrderDto.getCoffeeMachine().getId());
                serverResponseHtml.setText("");
                coffeeOrderService.saveCoffeeOrder(coffeeOrderDto, new AsyncCallback<CoffeeOrder>() {

                    public void onFailure(Throwable caught) {
                        dialogBox.setText("Remote Procedure Call - Failure");
                        serverResponseHtml.addStyleName("serverResponseLabelError");
                        serverResponseHtml.setHTML("ERROR ON SERVER");
                        dialogBox.center();
                        closeButton.setFocus(true);
                    }

                    public void onSuccess(CoffeeOrder result) {
                        dialogBox.setText("Remote Procedure Call");
                        serverResponseHtml.removeStyleName("serverResponseLabelError");
                        serverResponseHtml.setHTML(coffeeOrderDto.toString());
                        dialogBox.center();
                        closeButton.setFocus(true);
                    }
                });
            }
        }

        CoffeeOrderHandler handler = new CoffeeOrderHandler();
        confirmButton.addClickHandler(handler);
        coffeeIdField.addKeyUpHandler(handler);
    }
}
