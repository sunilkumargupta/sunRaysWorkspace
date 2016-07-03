define(['jquery', 'backbone'], 
		function($, Backbone) {
	
	// Module Below
	var MenuList = Backbone.Model.extend({
		
		defaults: {
			items: [
			    "Samosa",
			    "Dosa",
			    "Kachori"			  
			]
		}
		
	});
	
	// exports
	return MenuList;
});