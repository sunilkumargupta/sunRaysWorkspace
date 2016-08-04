define(['jquery', 'handlebars',	'backbone', 
        'app/views/menu',
        'app/views/menuitemdetails',
        'app/models/menuitem',
        'app/collections/menuitems'], 
		function($, Handlebars, Backbone, 
				MenuView,
				MenuItemDetails,
				MenuItem,
				MenuItems) {
	
	// JS Module Below

	var AppRouter = Backbone.Router.extend({
		routes: {
			"": "list",
			"menu-items/:item": "itemDetails"
		},
		
		list: function(){
			$('#app').html(this.menuView.render().el);
			$('#appDetail').empty();
		},
		itemDetails: function(item) {
			//this.menuItemView.model = this.menuItems.get(item);
			this.menuItemModel.set("menuId",item);
			this.menuItemModel.fetch();
			$('#appDetail').html(this.menuItemView.render().el);
		},
		
		initialize: function () {
			
			this.menuItems = new MenuItems();
			this.menuItems.fetch();
			this.menuView = new MenuView({collection: this.menuItems});
			
			this.menuItemModel = new MenuItem();
			this.menuItemView = new MenuItemDetails({ model: this.menuItemModel });
			
		},
		
	});
	
	var app = new AppRouter();
	
	// export stuff:
    return app;
	
	

});