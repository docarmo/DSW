class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(controller:"produto", action: "list")
        
		"500"(view:'/error')
	}
}
