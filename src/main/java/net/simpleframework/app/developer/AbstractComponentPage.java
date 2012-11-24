package net.simpleframework.app.developer;

import net.simpleframework.mvc.PageParameter;
import net.simpleframework.mvc.template.FormTemplatePage;

public abstract class AbstractComponentPage extends FormTemplatePage {

	@Override
	protected void onInit(final PageParameter pParameter) {
		super.onInit(pParameter);

		addImportCSS(getCssResourceHomePath(pParameter, AbstractComponentPage.class)
				+ "/component_utils.css");

		addHtmlViewVariable(getClass(), "comp");
	}
}
