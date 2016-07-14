requirejs.config({
  'baseUrl': '/MenuApp',
  'paths': {
    'app': 'js/app',
    'jquery': 'js/lib/jquery-latest',
    'underscore': 'js/lib/underscore-min',
    'backbone': 'js/lib/backbone-min',
    'handlebars': 'js/lib/handlebars-v1.3.0',
    'hbs': 'js/lib/require-handlebars-plugin/hbs'
  },
  

  'hbs': { // optional
      helpers: true,            // default: true
      i18n: false,              // default: false
      templateExtension: 'html', // default: 'hbs'
      partialsUrl: ''           // default: ''
  },
  
  'shim': {
	    'underscore': {
	      'exports': '_'
	    },
	    'backbone': {
	      'deps': ['jquery', 'underscore'],
	      'exports': 'Backbone'
	    },
	    'handlebars': {
	      'exports': 'Handlebars'
	    }
	  }
});

require(['backbone', 'app/app'], function(Backbone, Application) {
	
	window.app = Application;
	
	$(function(){
		Backbone.history.start();	
		Application.navigate('', { trigger: true });
	});
});