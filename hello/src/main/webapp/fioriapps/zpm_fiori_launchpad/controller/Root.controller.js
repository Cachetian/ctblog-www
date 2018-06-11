sap.ui.define([
	"sap/ui/core/mvc/Controller"
], function(Controller) {
	"use strict";

	var oToPage;
	
	return Controller.extend("zpm_fiori_launchpad.controller.Root", {
		
		onInit: function(){
			oToPage = new sap.m.Page();
			this.getView().byId("app").addPage(oToPage);
		},
		
		onPress_tile01: function(oEvent) {
			oToPage.removeAllContent();
			var oComp = sap.ui.getCore().createComponent({
				name: "zpm_fiori_app",
				url: "/fioriapps/zpm_fiori_app"
			});
			var oCompCon = new sap.ui.core.ComponentContainer();
			oCompCon.setComponent(oComp);
			oToPage.addContent(oCompCon);
			this.getView().byId("app").to(oToPage);
		}
	});
});