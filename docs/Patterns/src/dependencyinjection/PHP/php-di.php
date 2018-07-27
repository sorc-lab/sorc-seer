<?php

/** Example Without DI ===================================================== */
class GoogleMaps
{
	public function getCoordinatesFromAddress($address) {
		// calls Google Maps webservice
	}
}

class OpenStreetMap
{
	public function getCoordinatesFromAddress($address) {
		// calls OpenStreetMap webservice
	}
}

// The classic way of doing this:
class StoreService
{
	public function getStoreCoordinates($store) {
		$geolocationService = new GoogleMaps();

		// or $geolocationService = GoogleMaps::getInstance()
		// if you use singletons

		return $geolocationService
					->getCoordinatesFromAddress($store->getAddress());
	}
}

// What if we want to use the 'OpenStreetMap' instead of 'GoogleMaps'?
// We would have to change 'StoreService' class and everywhere else that
// 'new GoogleMaps()' is being called. Without DI, classes are tightly coupled
// to their dependencies.
/** ======================================================================== */


/** Example With DI ======================================================== */
class StoreService
{
	private $geolocationService;

	public function __construct(GeolocationService $geolocationService) {
		$this->geolocationService = $geolocationService;
	}

	public function getStoreCoordinates($store) {
		return $this->geolocationService
					->getCoordinatesFromAddress($store->getAddress());
	}
}

// And the services are defined using an interface:
interface GeolocationService {
	public function getCoordinatesFromAddress($address);
}

class GoogleMaps implements GeolocationService {...}
class OpenStreetMap implements GeolocationSercice {...}

// Now it's up to the user of 'StoreService' to decide which impl. to use. And
// it can be changed anytime, without having to rewrite the 'StoreService'.
/** ======================================================================== */


/** Example With PHP-DI ==================================================== */
// You may see that dependency injection will leave with one drawback: you now
// have to handle injecting dependencies. That's where a container, and
// specifically PHP-DI, can help you.

//Instead of writing:
$geolocationService = new GoogleMaps();
$storeService = new StoreService($geolocationService);

//You can write:
$storeService = $container->get('StoreService');

// and configure which GeolocationService PHP-DI should automatically inject in
// StoreService through configuration:

$container->set('GeolocationService', \DI\create('GoogleMaps'));

//If you change your mind, there's just one line of configuration to change
// now.
/** ======================================================================== */
