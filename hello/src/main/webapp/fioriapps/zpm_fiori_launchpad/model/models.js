sap.ui.define([
	"sap/ui/model/json/JSONModel",
	"sap/ui/Device"
], function(JSONModel, Device) {
	"use strict";

	return {

		createDeviceModel: function() {
			var oModel = new JSONModel(Device);
			oModel.setDefaultBindingMode("OneWay");
			return oModel;
		},

		createFioriAppsModel: function() {
			var oModel = new JSONModel({
				apps: [{
					name: "skyfioriapp01",
					url: "https://skyfioriapp01-i319998trial.dispatcher.hanatrial.ondemand.com/"
				}]
			});
			oModel.setDefaultBindingMode("OneWay");
			return oModel;
		}

	};
});