sap.ui.define([
	"sap/ui/core/mvc/Controller"
], function(Controller) {
	"use strict";

	return Controller.extend("zpm_fiori_app.controller.App", {
		onScanSuccess: function(oEvent) {
			var bCancelled = oEvent.getParameters("cancelled");
			if (bCancelled) {
				sap.m.MessageToast.show("Cancelled");
			} else {
				sap.m.MessageToast.show("Format:" + oEvent.getParameters("format") + ", Scanned:" + oEvent.getParameters("text"));
			}
		},
		
		onScanFail: function(oEvent) {
			sap.m.MessageToast.show("fail");
		},
		
		onPress_Button0: function(oEvent) {
			
		}
	});
});