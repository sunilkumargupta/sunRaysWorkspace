define(['jquery', 'backbone'], 
		function($, Backbone) {
	
	// Module Below
	var MenuItem = Backbone.Model.extend({
		idAttribute: "menuId",
		defaults: {
			menuId: '-1',
			menuName: 'menuName',
			category: 'category',
			imageId: 'imageId'
		}
		
	});
	
	// exports
	return MenuItem;
});