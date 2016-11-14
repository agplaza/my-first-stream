package es.codemotion.stream;

interface TerminalSink<T, R> extends Sink<T>
{
    default R getResult()
    {
        return null;
    }
}
