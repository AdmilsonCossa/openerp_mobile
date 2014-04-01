package com.oe.mobile;

import java.util.ArrayList;

public class Menu {
	// sets all the menuItem
		private class MenuItem {
			private int sequence;
			private String parentMenu;
			private String menu;

			// use sequence to order the menu
			// this is the sequence of the particular menu
			// etc, when the menu is MenuItem(1, "CRM", "Customer"), it will show as the first menu item in the "CRM" menu
			public MenuItem(int sequence, String parentMenu, String menu) {
				this.sequence=sequence;
				this.parentMenu = parentMenu;
				this.menu = menu;
			}

			public String getParent() {
				return parentMenu;
			}

			public String getMenu() {
				return menu;
			}

			public boolean isRoot() {
				if ("".endsWith(parentMenu))
					return true;

				return false;
			}
		}

		ArrayList<MenuItem> menuList = new ArrayList<MenuItem>();
		
		public Menu(){
			this.initMenu();
		}

		public void initMenu() {
			// root menu
			menuList.add(new MenuItem(1,"","Message"));
			menuList.add(new MenuItem(2,"","CRM"));
			menuList.add(new MenuItem(3,"","���"));
			menuList.add(new MenuItem(4,"","�ɹ�"));
			menuList.add(new MenuItem(5,"","����"));
			menuList.add(new MenuItem(6,"","����"));
			menuList.add(new MenuItem(7,"","����"));
			menuList.add(new MenuItem(8,"","TechTest"));
			
			// menu of ��Ϣ
			menuList.add(new MenuItem(1, "Message","��Ϣ"));
			
			// menu of CRM
			menuList.add(new MenuItem(1,"CRM","�ͻ���Ϣ"));
			menuList.add(new MenuItem(2,"CRM","����"));
			menuList.add(new MenuItem(3,"CRM","�̻�"));
			
			// menu of ���
			menuList.add(new MenuItem(1,"���","���ϲ�ѯ"));
			menuList.add(new MenuItem(2,"���","�ӿ���ѯ"));
			menuList.add(new MenuItem(3,"���","������"));
			
			// menu of �ɹ�
			menuList.add(new MenuItem(1,"�ɹ�","�ɹ�����"));
			menuList.add(new MenuItem(2,"�ɹ�","��ⵥ"));
			
			// menu of ����
			menuList.add(new MenuItem(1,"����","���۶���"));
			menuList.add(new MenuItem(2,"����","������"));
			
			// menu of ����
			menuList.add(new MenuItem(1,"����","����"));
			menuList.add(new MenuItem(2,"����","��Ʊ"));
			menuList.add(new MenuItem(3,"����","������������"));
			menuList.add(new MenuItem(4,"����","����ת��"));
			menuList.add(new MenuItem(5,"����","����Ʒ���"));
			
			// menu of TechTest
			menuList.add(new MenuItem(1,"TechTest","ChartTest"));
			menuList.add(new MenuItem(2,"TechTest","ScanTest"));
			menuList.add(new MenuItem(3,"TechTest","ImageTest"));
			menuList.add(new MenuItem(4,"TechTest","GPSTest"));
			
			
		}
		
		// get the particular menu Strings
		public ArrayList<String> constructMenu(String parentMenu){
			ArrayList<String> menu = new ArrayList<String>();
			for(MenuItem i: menuList){
				if (i.getParent().equals(parentMenu)){
					menu.add(i.getMenu());
				}
			}
			return menu;
		}
}
