
if __name__ == "__main__":
    import sys
    sys.path.append('..')

    from app.models.factory.geolocator_factory import GeolocatorFactory
    
    geolocator_factory = GeolocatorFactory()
    geolocator = geolocator_factory.make("Nominatim")
    location = geolocator.get_location("Wood Dale View, Woodale, Ballycragh, Firhouse Village ED, Tallaght, South Dublin, Dublin 24")
    print(location['address'])
