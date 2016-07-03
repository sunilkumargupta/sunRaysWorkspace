define(['jquery', 'handlebars',	'backbone', 
        'app/views/menuitemdetails', 'app/views/menu', 'app/views/menucategory', 
        'app/models/menuitem', 'app/models/menulist', 'app/collections/menuitems'], 
		function($, Handlebars, Backbone, 
				MenuItemDetails, MenuView, MenuCategoryView,
				MenuItem, MenuList, MenuItems) {
	
	// JS Module Below

	var AppRouter = Backbone.Router.extend({
		routes: {
			"": "list",
			"menu-items/new": "itemForm",
			"menu-items/:item": "itemDetails",
			"categories/:category": "categoryDetails"
		},
		
		list: function(){
			$('#app').html(this.menuView.render().el);
		},
		
		initialize: function () {
			
			this.menuItems = new MenuItems();
			this.menuItems.fetch();
			
			this.menuItemModel = new MenuItem();
			this.menuItemView = new MenuItemDetails(
				{
					model: this.menuItemModel
				}
			);
			
			this.menuView = new MenuView({collection: this.menuItems});
			
			this.menuCategoryView = new MenuCategoryView( 
				{
					category: 'Desserts',
					images: [
					     "gulabjamun.jpg",
					     "rasmalai.jpg",
					     "jalebi.jpg"					        
					]
				}					
			);
		},

		itemDetails: function(item) {
			this.menuItemView.model = this.menuItems.get(item);
			
			$('#app').html(this.menuItemView.render().el);
		},

		categoryDetails: function(category) {
			this.menuCategoryView.options.category = category;
			$('#app').html(this.menuCategoryView.render().el);
		},
		
		itemForm: function() {
			$('#app').html('New item form');
		}
	});
	
	var app = new AppRouter();
	
	// export stuff:
    return app;
	
	

});