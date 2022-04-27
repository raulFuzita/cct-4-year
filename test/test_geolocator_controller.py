
if __name__ == "__main__":
    import sys
    sys.path.append('..')

    import os
    from app.controller.geolocator.geolocator_controller import GeolocatorController
    from dotenv import load_dotenv

    load_dotenv()

    api_key = "full_privilege"
    address = "Wood Dale View, Woodale, Ballycragh, Firhouse Village ED, Tallaght, South Dublin, Dublin 24"
    
    req = {"api_key": api_key, "address": address}
    controller = GeolocatorController(req)
    location = controller.get_location()
    print(location)