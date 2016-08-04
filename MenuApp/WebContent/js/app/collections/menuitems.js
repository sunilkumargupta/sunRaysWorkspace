define(['jquery', 'backbone', 'app/models/menuitem'], 
		function($, Backbone, MenuItem) {
	
	// Module Below
	var MenuItems = Backbone.Collection.extend({

		model: MenuItem,
		url: '/MenuApp/data/menuItems/list',
		
		comparator: function(a, b) {
			if( a.get('menuId') < b.get('menuId')) {
				return -1;
			} else if( b.get('menuId') > a.get('menuId')) {
				return 1;
			}else {
				return 0;
			}
		},
	});
	
	// exports
	return MenuItems;
});