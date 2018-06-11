sap.ui.define([
	"sap/ui/core/mvc/Controller"
], function(Controller) {
	"use strict";

	var oApp, oToPage;

	return Controller.extend("zpm_fiori_launchpad.controller.Root", {

		onInit: function() {
			oApp = this.getView().byId("app");
			oToPage = new sap.m.Page();
			oApp.addPage(oToPage);
		},

		onPress_tile01: function(oEvent) {
			oToPage.removeAllContent();
			var oComp = sap.ui.getCore().createComponent({
				name: "zpm_fiori_app",
				url: "../zpm_fiori_app"
			});
			var oCompCon = new sap.ui.core.ComponentContainer();
			oCompCon.setComponent(oComp);
			oComp.setFlp(oApp);
			oToPage.addContent(oCompCon);
			oApp.to(oToPage);
		}
	});
});
