package net.simpleframework.app.developer.base.calendar;

import net.simpleframework.app.developer.AbstractComponentPage;
import net.simpleframework.common.html.element.EInputType;
import net.simpleframework.mvc.PageParameter;
import net.simpleframework.mvc.component.ui.calendar.CalendarBean;
import net.simpleframework.mvc.template.struct.CalendarInput;

public class CalendarPage extends AbstractComponentPage {

	@Override
	protected void onInit(final PageParameter pParameter) {
		super.onInit(pParameter);

		addComponentBean(pParameter, "testCalendar", CalendarBean.class);
	}

	public String calInput(final PageParameter pParameter) {
		return new CalendarInput("idCalendarField").setCalendarComponent("testCalendar")
				.setDateFormat("yyyy/MM/dd").setInputType(EInputType.textButton).toString();
	}
}
