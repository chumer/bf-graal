package cesquivias.bf;

import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameSlotTypeException;
import com.oracle.truffle.api.frame.VirtualFrame;

public class PrintDataNode extends BFNode {
    private final FrameSlot ptr;
    private final FrameSlot data;

    public PrintDataNode(FrameSlot ptr, FrameSlot data) {
        this.ptr = ptr;
        this.data = data;
    }

    @Override
    public void execute(VirtualFrame frame) {
        try {
            System.out.print((char) ((byte[]) frame.getObject(data))[frame.getInt(ptr)]);
        } catch (FrameSlotTypeException e) {
            e.printStackTrace();
        }
    }
}