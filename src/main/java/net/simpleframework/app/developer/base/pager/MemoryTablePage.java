package net.simpleframework.app.developer.base.pager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import net.simpleframework.app.developer.AbstractComponentPage;
import net.simpleframework.common.ado.query.IDataQuery;
import net.simpleframework.common.ado.query.ListDataObjectQuery;
import net.simpleframework.common.coll.ParameterMap;
import net.simpleframework.mvc.PageParameter;
import net.simpleframework.mvc.component.ComponentParameter;
import net.simpleframework.mvc.component.ui.pager.AbstractTablePagerHandler;
import net.simpleframework.mvc.component.ui.pager.TablePagerBean;
import net.simpleframework.mvc.component.ui.pager.TablePagerColumn;

public class MemoryTablePage extends AbstractComponentPage {
	@Override
	protected void onInit(final PageParameter pParameter) {
		super.onInit(pParameter);

		final TablePagerBean tablePager = (TablePagerBean) addComponentBean(pParameter,
				"DemoMemoryTable", TablePagerBean.class).setShowLineNo(true)
				.setContainerId("id_MemoryTablePage").setHandleClass(DemoMemoryTable.class);
		tablePager
				.addColumn(new TablePagerColumn("ID").setWidth(100).setTooltip("TablePagerColumn 1"))
				.addColumn(new TablePagerColumn("col2").setWidth(100).setTooltip("TablePagerColumn 2"))
				.addColumn(new TablePagerColumn("col3"));
	}

	public static class DemoMemoryTable extends AbstractTablePagerHandler {
		ArrayList<Map<?, ?>> data;

		@Override
		public IDataQuery<?> createDataObjectQuery(final ComponentParameter cParameter) {
			data = new ArrayList<Map<?, ?>>();
			for (int i = 0; i < 1000; i++) {
				final ParameterMap row = new ParameterMap();
				row.put("ID", "col1_" + i);
				row.put("col2", "col2_" + new Date());
				row.put("col3", "col3_" + UUID.randomUUID().toString());
				data.add(row);
			}
			return new ListDataObjectQuery<Map<?, ?>>(data);
		}

		@Override
		public Object getRowDataById(final ComponentParameter cParameter, final Object id) {
			for (final Map<?, ?> m : data) {
				if (m.get("ID").equals(id)) {
					return m;
				}
			}
			return null;
		}
	}
}
