package au.com.vaadinutils.editors;

import java.util.Iterator;

import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Field;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;


@SuppressWarnings("serial")
public class InputFormDialog extends Window
{

	private HorizontalLayout buttons;
	private Button cancelButton;
	private Button ok;

	public InputFormDialog(final UI parent, String title, Field<?> primaryFocusField, final FormLayout form,
			final InputFormDialogRecipient recipient)
	{
		setCaption(title);
		setModal(true);
		this.setClosable(false);
		this.setResizable(false);

		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(new MarginInfo(false, true, true, false));
		//layout.setMargin(true);
		layout.setSizeUndefined();
		layout.addComponent(form);

		buttons = new HorizontalLayout();
		buttons.setSpacing(true);

		cancelButton = new Button("Cancel", new Button.ClickListener()
		{
			public void buttonClick(ClickEvent event)
			{
				if (recipient.onCancel())
				{
					close();
				}
			}
		});
		buttons.addComponent(cancelButton);

		ok = new Button("Ok", new Button.ClickListener()
		{
			public void buttonClick(ClickEvent event)
			{
				try
				{
					Iterator<Component> itr = form.iterator();
					while (itr.hasNext())
					{
						Component comp = itr.next();
						if (comp instanceof Field<?>)
						{
							Field<?> field = (Field<?>) comp;
							field.validate();
						}
					}
					if (recipient.onOK())
					{
						close();
					}
				}
				catch (InvalidValueException e)
				{
					Notification.show(e.getMessage(), Type.ERROR_MESSAGE);
				}
			}
		});

		ok.setId("Ok");

		ok.setClickShortcut(KeyCode.ENTER);
		ok.addStyleName("default");
		buttons.addComponent(ok);
		

		layout.addComponent(buttons);
		layout.setComponentAlignment(buttons, Alignment.MIDDLE_RIGHT);

		this.setContent(layout);
		parent.addWindow(this);

		primaryFocusField.focus();
	}

	public void okOnly()
	{
		buttons.removeComponent(cancelButton);
	}

	public void setOkButtonLabel(String label)
	{
		ok.setCaption(label);
	}
	
	public void setCancelButtonLabel(String label)
	{
		cancelButton.setCaption(label);
	}
	
	public void showOkButton(boolean show)
	{
		ok.setVisible(show);
	}
}
