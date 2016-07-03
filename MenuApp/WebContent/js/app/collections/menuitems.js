define(['jquery', 'backbone', 'app/models/menuitem'], 
		function($, Backbone, MenuItem) {
	
	// Module Below
	var MenuItems = Backbone.Collection.extend({

		model: MenuItem,
		url: '/demoapp/json/items',
		
		comparator: function(a, b) {
			if( a.get('name') < b.get('name')) {
				return 1;
			} else if( b.get('name') > a.get('name')) {
				return -1;
			}
		},
	});
	
	// exports
	return MenuItems;
});