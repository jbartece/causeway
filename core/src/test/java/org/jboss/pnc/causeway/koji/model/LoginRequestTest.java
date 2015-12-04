package org.jboss.pnc.causeway.koji.model;

import org.commonjava.rwx.error.XmlRpcException;
import org.commonjava.rwx.estream.model.Event;
import org.commonjava.rwx.impl.estream.EventStreamGeneratorImpl;
import org.commonjava.rwx.impl.estream.EventStreamParserImpl;
import org.commonjava.rwx.impl.stax.StaxParser;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by jdcasey on 12/3/15.
 */
public class LoginRequestTest
    extends AbstractKojiModelTest
{

    private static final String CAPTURED_XML = "<?xml version='1.0'?>\n"
            + "<methodCall><methodName>sslLogin</methodName><params><param><value><nil/></value></param></params></methodCall>\n";

    @Test
    public void verifyVsCapturedHttpRequest()
            throws Exception
    {
        EventStreamParserImpl eventParser = new EventStreamParserImpl();
        bindery.render( eventParser, new LoginRequest() );

        List<Event<?>> objectEvents = eventParser.getEvents();
        eventParser.clearEvents();

        StaxParser parser = new StaxParser(CAPTURED_XML);
        parser.parse(eventParser);

        List<Event<?>> capturedEvents = eventParser.getEvents();
        eventParser.clearEvents();

        assertEquals( objectEvents, capturedEvents );
    }

    @Test
    public void roundTrip()
            throws Exception
    {
        EventStreamParserImpl eventParser = new EventStreamParserImpl();
        bindery.render( eventParser, new LoginRequest() );

        List<Event<?>> objectEvents = eventParser.getEvents();
        EventStreamGeneratorImpl generator = new EventStreamGeneratorImpl( objectEvents );

        LoginRequest parsed = bindery.parse( generator, LoginRequest.class );
        assertNotNull( parsed );
    }
}
