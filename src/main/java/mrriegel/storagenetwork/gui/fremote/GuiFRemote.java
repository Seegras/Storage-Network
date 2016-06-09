package mrriegel.storagenetwork.gui.fremote;

import mrriegel.storagenetwork.gui.AbstractGuiFRequest;
import mrriegel.storagenetwork.helper.NBTHelper;
import mrriegel.storagenetwork.items.ItemRemote;
import mrriegel.storagenetwork.tile.TileRequest.Sort;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;

public class GuiFRemote extends AbstractGuiFRequest {

	public GuiFRemote(Container inventorySlotsIn) {
		super(inventorySlotsIn);
	}

	@Override
	protected boolean getDownwards() {
		return NBTHelper.getBoolean(mc.thePlayer.inventory.getCurrentItem(), "down");
	}

	@Override
	protected void setDownwards(boolean d) {
		NBTHelper.setBoolean(mc.thePlayer.inventory.getCurrentItem(), "down", d);

	}

	@Override
	protected Sort getSort() {
		return Sort.valueOf(NBTHelper.getString(mc.thePlayer.inventory.getCurrentItem(), "sort"));
	}

	@Override
	protected void setSort(Sort s) {
		NBTHelper.setString(mc.thePlayer.inventory.getCurrentItem(), "sort", s.toString());
	}

	@Override
	protected BlockPos getPos() {
		return BlockPos.ORIGIN;
	}

	@Override
	protected BlockPos getMaster() {
		return ItemRemote.getTile(mc.thePlayer.inventory.getCurrentItem()).getPos();
	}

	@Override
	protected int getDim() {
		return NBTHelper.getInteger(mc.thePlayer.inventory.getCurrentItem(), "dim");
	}

}
