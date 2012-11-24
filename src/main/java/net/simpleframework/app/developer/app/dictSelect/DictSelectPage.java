package net.simpleframework.app.developer.app.dictSelect;

import net.simpleframework.app.developer.AbstractComponentPage;
import net.simpleframework.common.coll.KVMap;
import net.simpleframework.module.dict.web.component.dictSelect.DictTreeSelectBean;
import net.simpleframework.mvc.PageParameter;
import net.simpleframework.mvc.template.struct.DictInput;

public class DictSelectPage extends AbstractComponentPage {

	@Override
	protected void onInit(final PageParameter pParameter) {
		super.onInit(pParameter);

		addComponentBean(pParameter, new KVMap().add("name", "dictSelect").add("multiple", true),
				DictTreeSelectBean.class).setDictName("common.sex").setBindingText("idDictSelectText")
				.setBindingId("idDictSelectId").setDestroyOnClose(true);
	}

	public String dictInput(final PageParameter pParameter) {
		return new DictInput("idDictField").setDictComponent("dictSelect")
				.addParameter("dictName", "common.china.province").setHiddenField("idHiddenField")
				.toString();
		// return new
		// DictMultiSelectInput("idDictField").setDictComponent("dictSelect")
		// .addParameter("dictName", "common.china.province").toString();
	}
}
