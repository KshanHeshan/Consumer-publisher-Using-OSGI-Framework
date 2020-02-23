package publishera;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ServiceActivator implements BundleActivator {
	
	private ServiceRegistration publishServiceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		//ServiceActivator.context = bundleContext;
		System.out.println("Publisher A started his/her work....");
		ServicePublish servicePublish = new ServicePublisherImpl();
		publishServiceRegistration = bundleContext.registerService(ServicePublish.class.getName(), servicePublish, null);
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		//ServiceActivator.context = null;
		System.out.println("Publisher A ended his/her own work....");
		publishServiceRegistration.unregister();
	}

}
